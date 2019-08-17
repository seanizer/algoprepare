package sean.crackingTheCodingInterview.ch3StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

public interface MultiStack {
    static MultiStack getArrayBasedMultiStack(int partitions) {
        if (partitions < 1) throw new IllegalArgumentException();
        return new PartitionedMultiStack(partitions);
    }

    List<Stack> asStacks();

    OptionalInt pop(int offset);

    void push(int i, int offset);

    interface Stack {
        OptionalInt pop();

        void push(int i);
    }

    class PartitionedMultiStack implements MultiStack {
        static final int MULTIPLIER = 4;
        final int[] offsets;
        private final int partitions;
        int[] internalRepresentation;

        PartitionedMultiStack(int partitions) {
            this.partitions = partitions;
            offsets = new int[partitions];
            for (int i = 0; i < partitions; i++) {
                offsets[i] = i - partitions;
            }
            internalRepresentation = new int[partitions * MULTIPLIER];
        }

        int nextOffset(int offset) {
            checkBounds(offset);
            return currentOffset(offset) + partitions;
        }

        int currentOffset(int offset) {
            return offsets[offset];
        }

        private void checkBounds(int offset) {
            if (offset < 0 || offset >= partitions) throw new IllegalArgumentException();
        }

        @Override
        public List<Stack> asStacks() {
            List<Stack> stacks = new ArrayList<>();
            for (int i = 0; i < partitions; i++) {
                int offset = i;
                stacks.add(new Stack() {
                    @Override
                    public OptionalInt pop() {
                        return PartitionedMultiStack.this.pop(offset);
                    }

                    @Override
                    public void push(int i) {
                        PartitionedMultiStack.this.push(i, offset);
                    }
                });
            }
            return Collections.unmodifiableList(stacks);
        }

        @Override
        public OptionalInt pop(int offset) {
            int dataOffset = currentOffset(offset);
            if (dataOffset < 0) return OptionalInt.empty();
            offsets[offset] -= partitions;
            return OptionalInt.of(internalRepresentation[dataOffset]);
        }

        @Override
        public void push(int i, int offset) {
            int dataOffset = nextOffset(offset);
            ensureCapacity(dataOffset);
            offsets[offset] = dataOffset;
            internalRepresentation[dataOffset] = i;
        }

        private void ensureCapacity(int dataOffset) {
            if (internalRepresentation.length <= dataOffset) {
                internalRepresentation = Arrays.copyOf(internalRepresentation, internalRepresentation.length * 2);
            }
        }
    }
}

