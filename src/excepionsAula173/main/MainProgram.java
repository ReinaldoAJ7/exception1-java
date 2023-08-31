package excepionsAula173.main;
/**
 * Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
 * de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
 * dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
 * novamente a reserva com os dados atualizados. O programa não deve aceitar dados
 * inválidos para a reserva, conforme as seguintes regras:
 * - Alterações de reserva só podem ocorrer para datas futuras
 * - A data de saída deve ser maior que a data de entrada
 */
/**
 * Room number: 8021
 * Check-in date (dd/MM/yyyy): 23/09/2019
 * Check-out date (dd/MM/yyyy): 26/09/2019
 * Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 * ----------------------------------------------------------------------------------
 * Enter data to update the reservation:
 * Check-in date (dd/MM/yyyy): 24/09/2019
 * Check-out date (dd/MM/yyyy): 29/09/2019
 * Reservation: Room 8021, check-in: 24/09/2019, check-out: 29/09/2019, 5 nights
 ===================================================================================*/
/**
 *Room number: 8021
 * Check-in date (dd/MM/yyyy): 23/09/2019
 * Check-out date (dd/MM/yyyy): 21/09/2019
 * Error in reservation: Check-out date must be after check-in date
 ===================================================================================*/
/**
 *Room number: 8021
 * Check-in date (dd/MM/yyyy): 23/09/2019
 * Check-out date (dd/MM/yyyy): 26/09/2019
 * Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 * -----------------------------------------------------------------------------------
 * Enter data to update the reservation:
 * Check-in date (dd/MM/yyyy): 24/09/2015
 * Check-out date (dd/MM/yyyy): 29/09/2015
 * Error in reservation: Reservation dates for update must be future dates
 ====================================================================================*/
/**
 * Room number: 8021
 * Check-in date (dd/MM/yyyy): 23/09/2019
 * Check-out date (dd/MM/yyyy): 26/09/2019
 * Reservation: Room 8021, check-in: 23/09/2019, check-out: 26/09/2019, 3 nights
 * -----------------------------------------------------------------------------------
 * Enter data to update the reservation:
 * Check-in date (dd/MM/yyyy): 24/09/2020
 * Check-out date (dd/MM/yyyy): 22/09/2020
 * Error in reservation: Check-out date must be after check-in date
 =====================================================================================*/


import excepionsAula173.entities.Reservation;
import excepionsAula173.exceptions.DomainExceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format ");
       }
        catch (DomainExceptions e){
            System.out.println("Error in reservation: "+ e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error.\n");
        }



        sc.close();
    }
}
