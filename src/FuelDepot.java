import java.util.List;

public class FuelDepot {

    private FuelRobot filler;

    private List<FuelTank> tanks;

    public int nextTankToFill(int threshold){
        int min = filler.getCurrentIndex();
        for(int i = 0; i < tanks.size(); i++){
            if(tanks.get(i).getFuelLevel() <= threshold && tanks.get(i).getFuelLevel() < tanks.get(min).getFuelLevel()){
                min = i;
            }
        }
        return min;
    }

    public void moveToLocation(int locIndex){
        int pos = filler.getCurrentIndex();
        if(pos > locIndex && filler.isFacingRight()){
            filler.changeDirection();
        } if (pos < locIndex && !filler.isFacingRight()){
            filler.changeDirection();
        } if (locIndex > pos){
            filler.moveForward(locIndex - pos);
        } else if (locIndex < pos){
            filler.moveForward(pos - locIndex);
        }
    }

}
