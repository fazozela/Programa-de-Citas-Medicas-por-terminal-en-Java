package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{

    private String speciality;

    public Doctor(String name, String email){
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    //coleccion
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    //funcion que agrega
    public void addAvailableAppointments(String date, String time){



        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    //retorno de la coleccion
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado: Hospital Cruz Roja");
        System.out.println("Departamento de Cancerologia");
    }

    public static class AvailableAppointment{
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        public AvailableAppointment(String date, String time) {
            try {
                this.date = format.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Date getDate() {
            return date;
        }

        public String getDate(String DATE) {

            return format.format(date);
        }



        public String getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "Available Appointments \n Date: " + date + "\nTime: " + time;
        }
    }

}
