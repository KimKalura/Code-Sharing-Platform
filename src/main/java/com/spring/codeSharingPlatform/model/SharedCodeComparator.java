package com.spring.codeSharingPlatform.model;

import org.aspectj.apache.bcel.classfile.Code;

import java.util.Comparator;

public class SharedCodeComparator implements Comparator<SharedCode> {

    @Override
    public int compare(SharedCode sharedCode1, SharedCode sharedCode2) {
      //  return String.valueOf(sharedCode1.getCode()).compareTo(String.valueOf(sharedCode2.getCode()));
         return sharedCode1.getCode().compareTo(sharedCode2.getCode());
    }
}
