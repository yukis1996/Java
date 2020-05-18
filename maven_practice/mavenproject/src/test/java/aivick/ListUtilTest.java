package aivick;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListUtilTest
{
	/*
	 * evensof のテスト
	 */

    @Test
    void 偶数のみが抽出できること() {
        var actual = ListUtil.evensof(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(List.of(2,4,6), actual);
    }

    @Test
    void 偶数がない場合空のListを返すこと() {
    	var actual = ListUtil.evensof(List.of(1,5,7));
    	assertEquals(List.of(), actual);
    }

    @Test
    void 引数が空のリスト場合() {
    	var actual = ListUtil.evensof(List.of());
    	assertEquals(List.of(), actual);
    	// これはたして必要か？
    }

    /*
     *  replicate のテスト
     */

    @Test
    void 引数1の数だけ引数2が抽出できること() {
    	var actual = ListUtil.replicate(4, "hoge");
    	assertEquals(List.of("hoge", "hoge", "hoge", "hoge"), actual);
    }

    @Test
    void 引数1の値に0を指定した場合空のリストを返す() {
    	var actual = ListUtil.replicate(0, "hoge");
    	assertEquals(List.of(), actual);
    }

    @Test
    void 引数2が空の場合() {
    	var actual = ListUtil.replicate(3, "");
    	assertEquals(List.of("", "", ""), actual);
    	// 必要？　空の場合も空のリストが生成されてしまうため別処理を施すのが良さそう
    }

    /*
     * zip のテスト
     */

    @Test
    void 引数1と引数2のサイズが違う場合でも小さいサイズに合わせて返すこと1() {
    	var actual = ListUtil.zip(List.of(22,44,7), List.of(1,3,6,8,9,44));
    	assertEquals(3, actual.size());
    }

}