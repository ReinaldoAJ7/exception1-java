package excepionsAula173.entities;

import excepionsAula173.exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut){//throws DomainExceptions {
        if(!checkOut.after(checkIn)){
            throw new DomainExceptions("* Check-out date must be after check-in date\n");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Long duration(){
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut){//throws DomainExceptions{
        Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            throw new DomainExceptions("* Reservation dates for update must be future dates.\n");
        }
        if(!checkOut.after(checkIn)){
            throw new DomainExceptions("* Check-out date must be after check-in date\n");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "\n" +
                "\n***************** - New reservation - *****************" +
                "\nRoom number: " + roomNumber +
                "\nCheck in: " + checkIn +
                "\nCheck out: " + checkOut+
                "\nDuration "+duration()+" nights" +
                "\n=========================================================\n";
    }
}
