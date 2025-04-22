package Report;

import StatWords.Counter;
import StatWords.WordStat;

import java.util.*;

public class ReportGenerator {


    public List<ReportRow> listGen(WordStat table){
        List<ReportRow> list=new ArrayList<>();
        for(Map.Entry<String, Counter> entry: table.statistic.entrySet()){

            Counter value =entry.getValue();
            int intValue= value.getCounter();
            float realValue=(float)intValue;
            list.add(new ReportRow(entry.getKey(), intValue, 100*realValue/table.getTotalCount()));
        }

        list.sort((o1, o2) -> Integer.compare(o2.getFreq(), o1.getFreq()));
        return list;
    }
}
