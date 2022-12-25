package day13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DistressOrderTest {
    @Test
    void oneStartInOrder_isInorder_true() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[1,1,3,1,1]", "[1,1,5,1,1]")).isTrue();
    }

    @Test
    void twoFrames_isInorder_true() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[[1],[2,3,4]]", "[[1],4]")).isTrue();
    }

    @Test
    void rightIsSmaller_isInorder_false() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[9]", "[[8,7,6]]")).isFalse();
    }

    @Test
    void leftIsOutOfItems_isInorder_true() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[[4,4],4,4]", "[[4,4],4,4,4]")).isTrue();
    }

    @Test
    void rightOutOfItems_isInorder_false() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[7,7,7,7]", "[7,7,7]")).isFalse();
    }

    @Test
    void leftSizeOutOfItems_isInorder_true() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[]", "[3]")).isTrue();
    }

    @Test
    void leftHasMoreEmpty_isInorder_false() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[[[]]]", "[[]]")).isFalse();
    }

    @Test
    void complexInput_isInorder_false() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[1,[2,[3,[4,[5,6,7]]]],8,9]", "[1,[2,[3,[4,[5,6,0]]]],8,9]")).isFalse();
    }

    @Test
    void listVsSingle_isInorder_true() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[[2]]", "[3]")).isTrue();
    }

    @Test
    void listVsSingle_isInorder_false() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[3]", "[[2]]")).isFalse();
    }

    @Test
    void emptyVsSingle_isInorder_false() {
        DistressOrder cut = new DistressOrder();
        assertThat(cut.isInRightOrder("[[[]]]", "[[2]]")).isTrue();
        assertThat(cut.isInRightOrder("[[[]]]", "[[[]]]")).isFalse();
        assertThat(cut.isInRightOrder("[[2]]", "[[[]]]")).isFalse();
        assertThat(cut.isInRightOrder("[[1],[2,3,4]]", "[1,[2,[3,[4,[5,6,0]]]],8,9]")).isTrue();
        assertThat(cut.isInRightOrder("[[1],[2,3,4]]", "[[1],4]")).isTrue();
        assertThat(cut.isInRightOrder("[[1],4]", "[[1],[2,3,4]]")).isFalse();
        assertThat(cut.isInRightOrder("[[1],4]", "[[1],4]")).isFalse();
        assertThat(cut.isInRightOrder("[[1],4]", "[1,[2,[3,[4,[5,6,0]]]],8,9]")).isFalse();
        assertThat(cut.isInRightOrder("[[1]]", "[[[[2]]]]")).isTrue();
        assertThat(cut.isInRightOrder("[[[[2]]]]", "[[1]]")).isFalse();
        assertThat(cut.isInRightOrder("[[10]]", "[[3,[],[7,4,8,[]],1]]")).isFalse();


    }

}