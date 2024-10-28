package EstruturaDados.Filas;

public class EmergencyPatient implements Comparable<EmergencyPatient>
{
    int priority;
    int number;
    String orderOfPriority;

    public EmergencyPatient(String priority, int number)
    {
        setPriorityLevel(priority);
        this.number = number;
    }

    public EmergencyPatient(int priority, int number)
    {
        setOrderOfPriority(priority);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPriority() {
        return priority;
    }

    public String getOrderOfPriority() {
        return orderOfPriority;
    }

    public void setOrderOfPriority(int orderOfPriority)
    {
        this.priority = orderOfPriority;
        switch (orderOfPriority)
        {
            case 1:
                this.orderOfPriority = "Red";
                break;

            case 2:
                this.orderOfPriority = "Yellow";
                break;

            case 3:
                this.orderOfPriority = "Green";
                break;
        }
    }

    public void setPriorityLevel(String priority)
    {
        orderOfPriority = priority;
        switch (priority)
        {
            case "Red":
                this.priority = 1;
                break;

            case "Yellow":
                this.priority = 2;
                break;

            case "Green":
                this.priority = 3;
                break;
        }
    }

    @Override
    public int compareTo(EmergencyPatient obj)
    {
        if(getPriority() > obj.getPriority()) {
            return 1;
        }
        else if(getPriority() < obj.getPriority()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "EmergencyPatient { " + "orderOfPriority: " + orderOfPriority + ", number: " + number + " }" + "\n";
    }
}
