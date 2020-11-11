package it.unimi.di.abd;

import it.unimi.di.abd.adapter.SourceAdapter;
import it.unimi.di.abd.model.SourceRecord;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SQLAdapter implements SourceAdapter {
    @Override
    public Stream<SourceRecord> stream() {
        return IntStream.range(0,10000)
                .mapToObj(e -> new SourceRecord(String.format("{key:%1$d,\"item\":%1$d}",e),"key"))
//                .map(e -> {
//                    if(e.key.equals("1")){
//                        return new SourceRecord(e.key,"item");
//                    } else {
//                        return e;
//                    }
//                })
//                .filter(e -> !e.key.equals("1"))
                ;
    }
}
