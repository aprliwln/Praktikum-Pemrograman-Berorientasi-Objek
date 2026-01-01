package app;                    //di dalam folder app
import manage.PlaylistManage;   //import file PlaylistManage dari folder manage

public class Main {
    public static void main(String[] args) throws Exception {
        //mulai aplikasi
        PlaylistManage pm = new PlaylistManage(); //Object
        pm.menu(); //memanggil menu
    }
}