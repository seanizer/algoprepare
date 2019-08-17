package sean.crackingTheCodingInterview.ch3StacksAndQueues;

import static org.assertj.core.api.Assertions.assertThat;

class MinStackTest {


    void intMinStack() {
        MinStack<Integer> ms = MinStack.get();
        assertThat(ms.min()).isEmpty();
        assertThat(ms.pop()).isEmpty();

        ms.push(10);
        ms.push(9);
        ms.push(3);
        ms.push(1);
        ms.push(27);

        assertThat(ms.pop()).hasValue(27);
        assertThat(ms.min()).hasValue(1);

        assertThat(ms.pop()).hasValue(1);
        assertThat(ms.min()).hasValue(3);

        assertThat(ms.pop()).hasValue(3);
        assertThat(ms.min()).hasValue(9);

        assertThat(ms.pop()).hasValue(9);
        assertThat(ms.min()).hasValue(10);

        assertThat(ms.pop()).hasValue(10);
        assertThat(ms.min()).isEmpty();
        assertThat(ms.pop()).isEmpty();


    }

}