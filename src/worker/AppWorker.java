package worker;

import java.util.Calendar;
import obs.Colleague;
import mediator.Mediator;
import event.Event;

public class AppWorker implements Colleague {
    
    private Mediator mediator;
    private BroadcastType broadcastType;
    private Calendar darkCal;
    private Calendar lightCal;

    public AppWorker(Mediator mediator) {
        this.mediator = mediator;
        initDate();
        setDate();
        startWork();
    }
    
    private void startWork() {
        new Thread() {
            public void run() {
                try {
                    while (true){
                        if (isMatch(darkCal)) {
                            broadcastType = new DarkType(mediator);
                            broadcastType.customBroadcast();
                            break;
                        }
                        else if(isMatch(lightCal)) {
                            broadcastType = new LightType(mediator);
                            broadcastType.customBroadcast();
                            break;
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }.start();
    }

	@Override
	public void update(Event event) {
	}

    private void initDate() {
        darkCal = Calendar.getInstance();
        darkCal.set(Calendar.HOUR_OF_DAY, 18);
        darkCal.set(Calendar.MINUTE, 0);
        darkCal.set(Calendar.SECOND, 0);

        lightCal = Calendar.getInstance();
        lightCal.set(Calendar.HOUR_OF_DAY, 6);
        lightCal.set(Calendar.MINUTE, 0);
        lightCal.set(Calendar.SECOND, 0);
    }

    private void setDate() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour < 18) {
            broadcastType = new LightType(mediator);
        }
        else {
            broadcastType = new DarkType(mediator);
        }
        broadcastType.customBroadcast();
    }

    private boolean isMatch(Calendar selectedCal) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);

        int selectedHour = selectedCal.get(Calendar.HOUR_OF_DAY);
        int selectedMinutes = selectedCal.get(Calendar.MINUTE);
        int selectedSeconds = selectedCal.get(Calendar.SECOND);
        
        return match(hour, selectedHour) && match(minutes, selectedMinutes) && match(seconds, selectedSeconds);
    }

    private boolean match(int val1, int val2) {
        return val1 == val2;
    }
}
