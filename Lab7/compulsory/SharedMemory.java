package org.example;

import java.util.List;
import java.util.Set;

public class SharedMemory {
    List<Integer> allTokenList;
    MatrixMap map;

    public SharedMemory() {
    }

    public SharedMemory(List<Integer> allTokenList, MatrixMap map) {
        this.allTokenList = allTokenList;
        this.map = map;
    }

    public List<Integer> getAllTokenList() {
        return allTokenList;
    }

    public List<Integer> setAllTokenList(Set<Integer> allTokenList) {
        this.allTokenList = (List<Integer>) allTokenList;
        return null;
    }

    public MatrixMap getMap() {
        return map;
    }

    public void setMap(MatrixMap map) {
        this.map = map;
    }
}
