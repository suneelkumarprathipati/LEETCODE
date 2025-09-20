/**
 * A network router implementation that efficiently manages packets with memory constraints.
 * This router stores packets in a queue, supports deduplication, and provides efficient 
 * time-range queries using binary search and virtual list implementation with start indices.
 */
class Router {
    /**
     * Represents a network packet with source, destination, and timestamp information.
     */
    static class Packet {
        private final int sourceId;
        private final int destinationId;
        private final int timestamp;
        
        public Packet(int sourceId, int destinationId, int timestamp) {
            this.sourceId = sourceId;
            this.destinationId = destinationId;
            this.timestamp = timestamp;
        }
        
        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof Packet)) return false;
            Packet packet = (Packet) object;
            return sourceId == packet.sourceId && 
                   destinationId == packet.destinationId && 
                   timestamp == packet.timestamp;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(sourceId, destinationId, timestamp);
        }
    }
    
    // Number of free slots left in memory
    private int freeSlots;
    
    // FIFO queue for packet order
    private final Queue<Packet> packetFifoQueue;
    
    // Set for O(1) duplicate detection
    private final Set<Packet> packetLookupSet;
    
    // Map: destinationId → list of packets for that destination
    private final Map<Integer, List<Packet>> destinationPacketListMap;
    
    // Map: destinationId → virtual start index of valid packets
    private final Map<Integer, Integer> destinationStartIndexMap;
    
    public Router(int memoryLimit) {
        this.freeSlots = memoryLimit;
        this.packetFifoQueue = new LinkedList<>();
        this.packetLookupSet = new HashSet<>();
        this.destinationPacketListMap = new HashMap<>();
        this.destinationStartIndexMap = new HashMap<>();
    }
    
    public boolean addPacket(int sourceId, int destinationId, int timestamp) {
        Packet incomingPacket = new Packet(sourceId, destinationId, timestamp);
        
        if (packetLookupSet.contains(incomingPacket)) {
            return false; // duplicate
        }
        
        if (freeSlots > 0) {
            freeSlots--;
        } else {
            Packet evictedPacket = packetFifoQueue.remove();
            packetLookupSet.remove(evictedPacket);
            
            int evictedDestination = evictedPacket.destinationId;
            int oldStartIndex = destinationStartIndexMap.get(evictedDestination);
            destinationStartIndexMap.put(evictedDestination, oldStartIndex + 1);
        }
        
        packetFifoQueue.add(incomingPacket);
        packetLookupSet.add(incomingPacket);
        
        destinationPacketListMap.putIfAbsent(destinationId, new ArrayList<>());
        destinationStartIndexMap.putIfAbsent(destinationId, 0);
        
        destinationPacketListMap.get(destinationId).add(incomingPacket);
        
        return true;
    }
    
    public int[] forwardPacket() {
        if (packetFifoQueue.isEmpty()) {
            return new int[]{};
        }
        
        Packet packetToSend = packetFifoQueue.remove();
        packetLookupSet.remove(packetToSend);
        
        int destinationId = packetToSend.destinationId;
        List<Packet> packetList = destinationPacketListMap.get(destinationId);
        
        int updatedStartIndex = destinationStartIndexMap.get(destinationId) + 1;
        destinationStartIndexMap.put(destinationId, updatedStartIndex);
        
        if (updatedStartIndex >= packetList.size()) {
            destinationPacketListMap.remove(destinationId);
            destinationStartIndexMap.remove(destinationId);
        }
        
        freeSlots++;
        
        return new int[]{packetToSend.sourceId, packetToSend.destinationId, packetToSend.timestamp};
    }
    
    public int getCount(int destinationId, int startTime, int endTime) {
        List<Packet> packetList = destinationPacketListMap.get(destinationId);
        if (packetList == null || packetList.isEmpty()) {
            return 0;
        }
        
        int startIndex = destinationStartIndexMap.getOrDefault(destinationId, 0);
        
        int lowerBound = findLowerBoundIndex(packetList, startTime, startIndex);
        int upperBound = findUpperBoundIndex(packetList, endTime, startIndex);
        
        return upperBound - lowerBound;
    }
    
    private int findLowerBoundIndex(List<Packet> packetList, int time, int startIndex) {
        int left = startIndex;
        int right = packetList.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (packetList.get(mid).timestamp >= time) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int findUpperBoundIndex(List<Packet> packetList, int time, int startIndex) {
        int left = startIndex;
        int right = packetList.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (packetList.get(mid).timestamp > time) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}