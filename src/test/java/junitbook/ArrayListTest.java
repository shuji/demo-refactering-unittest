package junitbook;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class ArrayListTest {

    public static class リストが初期状態の時 {

        private ArrayList<String> sut;

        @Before
        public void setUp() throws Exception {
            sut = new ArrayList<>();
        }

        @Test
        public void sizeは0を返す() throws Exception {
            assertThat(sut.size(), is(0));
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void get_0はIndexOutOfBoundsExceptionを送出する() throws Exception {
            sut.get(0);
        }

    }

    public static class リストに1件の文字列を含む時 {

        private ArrayList<String> sut;

        @Before
        public void setUp() throws Exception {
            sut = new ArrayList<>();
            sut.add("hello");

        }

        @Test
        public void sizeは1を返す() throws Exception {
            assertThat(sut.size(), is(1));
        }

        @Test
        public void get_0はhelloを返す() throws Exception {
            assertThat(sut.get(0), is("hello"));
        }

    }

    public static class リストに2件の文字列を含む時 {

        private ArrayList<String> sut;

        @Before
        public void setUp() throws Exception {
            sut = new ArrayList<>();
            sut.add("hello");
            sut.add("world");
        }

        @Test
        public void sizeは2を返す() throws Exception {
            assertThat(sut.size(), is(2));
        }

        @Test
        public void get_0はhelloを返す() throws Exception {
            assertThat(sut.get(0), is("hello"));
        }

        @Test
        public void get_1はworldを返す() throws Exception {
            assertThat(sut.get(1), is("world"));
        }
    }

}
