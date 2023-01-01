public class Constants {
    public static final int IGNORE = -999;
    public static final int REGULAR_APARTMENT = 1;
    public static final int PENTHOUSE_APARTMENT = 2;
    public static final int COTTAGE = 3;
    public static final int BASEMENT_FLOOR = -1;
    public static final int MIN_ROOMS_NUMBER = 1;
    public static final int MIN_HOUSE_NUMBER = 1;
    public static final int FOR_RENT = 1;
    public static final int FOR_SALE = 2;


    public static final int RELATOR = 1;
    public static final int REGULAR = 2;
    public static final int RELATOR_MAX_POST = 5;
    public static final int REGULAR_MAX_POST = 2;
    public static final String REGEX_DIGITS = ".*\\d+.*";
    public static final String REGEX_SYMBOL = ".*[_||%||$]+.*";
    public  static final int MIN_PASSWORD_LENGTH = 5;
    public static final String PHONE_NUMBER_REGEX = "^(\\d{10})$";
    public static final String PHONE_NUMBER_PREFIX_REGEX = "^05.*";
    public static final int NEGEV_DISTRICT = 1;
    public static final int SOUTHERN_DISTRICT = 2;
    public static final int CENTRAL_DISTRICT = 3;
    public static final int SHARON_DISTRICT = 4;
    public static final int NORTHERN_DISTRICT = 5;
    public static final String[] EILAT_STREETS = {"Hativat Hanegev", "Sheshet Hayamim", "Shoham", "Abuhatzira", "Roded", "Ein Mor", "Dakar", "Sinai", "Peres", "Barnea"};
    public static final String[] BEER_SHEVA_STREETS = {"Bialik", "Mivtza Nahshon", "Metzada", "Regger Av.", "Rambam", "Ein Gedi", "HaShalom", "Negba", "HaHida", "Bar Giora"};
    public static final String[] MITZPE_RAMON_STREETS = {"Ein Ovdat", "Ramon", "Nitzana", "HaShita", "Ein Zik", "Ein Shahak", "Gvanim", "Ein Meshek", "HaHelmonit", "Ein Akev"};
    public static final String[] KIRYAT_GAT_STREETS = {"Lakhish", "Gat", "HaDarom", "HaZait", "HaRimon", "Adoriem", "Tzahal", "Dor", "Micha", "Anatot"};
    public static final String[] MODIIN_STREETS = {"Ester HaMalka", "Levi", "Shimon", "Yosef", "Nahal Zin", "Emek HaEla", "Emek Dotan", "HaHshmonaim", "Shivtei Israel", "Lea Imenu"};
    public static final String[] BEIT_SHEMESH_STREETS = {"HaYarkon", "HaDan", "Ayalon", "Rashi", "Rival", "Ben Kisma", "Maapilei Egoz", "HaAliya", "HaGalil", "HaTavor"};
    public static final String[] HOLON_STREETS = {"Etzel", "HaHistadrut", "Yigal Yadin", "Deganya", "Anilevitch", "Moshe Sharet", "Shenkar", "Maalot", "Volfson", "Beit Lehem"};
    public static final String[] HOD_HASHRON_STREETS = {"HaGeula", "Hahomesh", "Aviv", "Tavas", "Hertzel", "Yeshurun", "Yedidut", "HaDror", "Odem", "Eshkol"};
    public static final String[] TVERIA_STREETS = {"Lechi", "HaDekel", "Hevron", "Brener", "Moran", "Golda Meir", "Ahad HaAm", "HaShomer", "Tzeelon", "HaHermon"};
    public static final String[] KIRYAT_SHMONA_STREETS = {"Hatzav", "Dan", "Halevanon", "Yuvalim", "Tel Hai", "Nurit", "HaVradim", "Har Hatzofim", "Hayarden", "HaNasi"};

    public static final int CREATE_USER = 1;
    public static final int USER_LOGIN = 2;
    public static final int END_SESSION = 3;
    public static final int POST_NEW_PROPERTY = 1;
    public static final int REMOVE_PROPERTY = 2;
    public static final int PRINT_ALL_PROPERTIES = 3;
    public static final int PRINT_USER_PROPERTIES = 4;
    public static final int SEARCH_PROPERTIES = 5;
    public static final int LOG_OUT_AND_RETURN = 6;
    public static final int INITIALIZING_SIZE = 0;
}
