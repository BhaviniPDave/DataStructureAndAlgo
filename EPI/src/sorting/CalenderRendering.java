package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalenderRendering {

    public static class  Event {
        public int start, finish;
        public  Event (int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }
    private static class Endpoint {
        public int time;
        public boolean isStart;
        public Endpoint(int  time,boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }

    public static int  findMaxSimultanousEvents(List<Event> A) {

        //Builds an array of all endpoints
        List<Endpoint> E = A.stream().map(event -> List.of(new Endpoint(event.start,true),
                                                new Endpoint(event.finish,false)))
                            .flatMap(List :: stream)
                            .collect(Collectors.toList());
        //Sorts the endpoint array according to time , breaking ties by putting start time before end time.
        E.sort((a,b) -> {
            if(a.time != b.time)
                return Integer.compare(a.time,b.time);
            //If times are equal, an endpoint that starts and interval comes first
            return a.isStart &&  !b.isStart ? -1 : !a.isStart && b.isStart?1:0;
        }
        );

        int maxNumSimultanousEvent = 0, numSimultanouesEvents = 0;
        for(Endpoint endpoint: E){
            if(endpoint.isStart){
                ++ numSimultanouesEvents;
                maxNumSimultanousEvent = Math.max(numSimultanouesEvents,maxNumSimultanousEvent);
            }
            else {
                --numSimultanouesEvents;
            }
        }
        return  maxNumSimultanousEvent;
    }

    public static void main(String[] args) {
        List<Event> A = new ArrayList<>();
        A.add(new Event(1,5));
        A.add(new Event(6,10));
        A.add(new Event(11,13));
        A.add(new Event(14,15));
        A.add(new Event(2,7));
        A.add(new Event(8,9));
        A.add(new Event(12,15));
        A.add(new Event(4,5));
        A.add(new Event(9,17));

        System.out.println(findMaxSimultanousEvents(A));

    }
}
