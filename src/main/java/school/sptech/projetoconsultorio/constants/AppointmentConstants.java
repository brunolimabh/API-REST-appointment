package school.sptech.projetoconsultorio.constants;

public class AppointmentConstants {
    public final static String BASE_PATH = "/appointments";
    public final static String LIST_BY_ID_PATH = "/{id}";
    public final static String LIST_BY_DOCTOR_PATH = "/filter-doctor/{doctorId}";
    public final static String AVG_PRICE_PATH = "/avg-price";
    public final static String SUM_PRICE_BY_DOCTOR_PATH = "/sum-price-doctor/{doctorId}";
    public final static String LIST_BY_DOCTOR_AND_DATE_PATH = "/filter-date-doctor/{doctorId}";
    public final static String UPDATE_NAME_PATH = "/{id}";
    public final static String REMOVE_PATH = "/{id}";
}
