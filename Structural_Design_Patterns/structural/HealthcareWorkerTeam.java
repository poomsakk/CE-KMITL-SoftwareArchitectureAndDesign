package structural;

import java.util.ArrayList;
import java.util.List;

public class HealthcareWorkerTeam implements HealthcareServiceable{
    private List<HealthcareServiceable> serviceList = new ArrayList<HealthcareServiceable>();
    @Override
    public void service() {
        for(HealthcareServiceable item : serviceList){
            item.service();
        }
    }

    @Override
    public double getPrice() {
        int totalPrice = 0;
        for(HealthcareServiceable item : serviceList){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void addMember(HealthcareServiceable e){
        serviceList.add(e);
    }

    public void removeMember(HealthcareServiceable e){
        serviceList.remove(e);
    }

}
