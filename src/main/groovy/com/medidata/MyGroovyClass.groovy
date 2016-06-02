package com.medidata

class MyGroovyClass {

    def value
    private values = []

    def add(value) {
        values << value
    }

    def get(int index) {
        values[index]
    }

}
