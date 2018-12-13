package com.guava;


import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class GuavaDemo {

    public static void main(String[] args) {

        Set<String> a = Sets.newHashSet();
        Set<String> b = Sets.newHashSet();
        Sets.SetView<String> c = Sets.intersection(a, b);


    }
}
