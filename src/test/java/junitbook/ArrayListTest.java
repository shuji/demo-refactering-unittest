package junitbook;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArrayListTest {

    @Test
    public void リストが初期状態の時sizeは0を返す() throws Exception {
        ArrayList<String> sut = new ArrayList<>();
        assertThat(sut.size(), is(0));
    }

    @Test
    public void リストに1件の文字列を含む時sizeは1を返す() throws Exception {
        ArrayList<String> sut = new ArrayList<>();
        sut.add("hello");
        assertThat(sut.size(), is(1));
    }

    @Test
    public void リストに2件の文字列を含む時sizeは2を返す() throws Exception {
        ArrayList<String> sut = new ArrayList<>();
        sut.add("hello");
        sut.add("world");
        assertThat(sut.size(), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void リストが初期状態の時get_0はIndexOutOfBoundsExceptionを送出する() throws Exception {
        ArrayList<String> sut = new ArrayList<>();
        sut.get(0);
    }

    @Test
    public void リストに1件の文字列を含む時get_0はhelloを返す() throws Exception {
        ArrayList<String> sut = new ArrayList<>();
        sut.add("hello");
        assertThat(sut.get(0), is("hello"));
    }

    @Test
    public void リストに2件の文字列を含む時get_0はhelloを返す() throws Exception {
        ArrayList<String> sut = new ArrayList<>();
        sut.add("hello");
        sut.add("world");
        assertThat(sut.get(0), is("hello"));
    }

    @Test
    public void リストに2件の文字列を含む時get_1はworldを返す() throws Exception {
        ArrayList<String> sut = new ArrayList<>();
        sut.add("hello");
        sut.add("world");
        assertThat(sut.get(1), is("world"));
    }
}
