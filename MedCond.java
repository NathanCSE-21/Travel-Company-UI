public class MedCond {

    static String mdContact;
    static String mdPhone;
    static String algType;
    static String illType;

    public MedCond(String mdContact, String mdPhone, String algType, String illType) {

        this.mdContact = mdContact;
        this.mdPhone = mdPhone;
        this.algType = algType;
        this.illType = illType;

    }

    static void getMdContact() {
        System.out.println("MdContact: " + mdContact);
    }

    static void getMdPhone() {
        System.out.println("MdPhone: " + mdPhone);
    }

    static void getAlgType() {
        System.out.println("AlgType: " + algType);
    }

    static void getIllType() {
        System.out.println("IllType: " + illType);
    }

    static void updateMdContact(String mdcontact) {
        mdContact = mdcontact;
    }

    static void updateMdPhone(String mdphone) {
        mdPhone = mdphone;
    }

    static void updateIllType(String illtype) {
        illType = illtype;
    }

} 