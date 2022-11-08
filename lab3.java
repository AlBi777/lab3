package lab_3;
import java.util.Scanner;

public class Main{
     public static void main(String[] args) {
	camera _camera = new camera(0, 0);
	battery _battery = new battery(0, "type");
	memory _memory = new memory(0, 0);
	screen _screen = new screen(0, "type");
	systema _system = new systema("name", 0);
	System.out.println("Инициализация прошла успешно.");
	smartphone sp = new smartphone(_camera,_battery,_memory,_screen,_system);
	sp.input();
	sp.check();
	sp.print();
	sp.battery_status();
	}
}

class smartphone {

	private static camera camera_get;
	private static battery battery_get;
	private static memory memory_get;
	private static screen screen_get;
	private static systema system_get;
	public smartphone(systema sys_get) {
	system_get = sys_get;
        }
	public smartphone(camera cam_get, battery bat_get, memory mem_get, screen scr_get, systema sys_get)
	{
	camera_get = cam_get;
	battery_get = bat_get;
	memory_get = mem_get;
	screen_get = scr_get;
	system_get = sys_get;
        }
	public static void input(){
	camera_get.input();
	battery_get.input();
	memory_get.input();
	screen_get.input();
	system_get.input();
        }

	public static void print(){
	camera_get.print();
	battery_get.print();
	memory_get.print();
	screen_get.print();
	system_get.print();
        }

	public static void battery_status() {
	int month;
	System.out.println("\nПроверка емкости батареи.");
        System.out.println("Сколько месяцев прошло с покупки: ");
	Scanner in = new Scanner(System.in);
        month = in.nextInt();
	System.out.println("Примерная емкость батареи - " + (battery_get.capacity - (battery_get.capacity / 100 * month)));
        }
        
        public static void check() {
	System.out.println("Проверка."); int choice; Scanner in = new Scanner(System.in);
	if (battery_get.type.equals(battery_get.types[0]) || battery_get.type.equals(battery_get.types[1]) || battery_get.type.equals(battery_get.types[2])) {
	}
	else {
		System.out.println("Тип батареи не соответствует Li-Ion, NiCd, NIMH.\n Оставить(0) или изменить(1) тип: ");
		choice = in.nextInt();
		if (choice == 1) {
			System.out.println("Введите тип батареи:");
			battery_get.type = in.next();
		}
	} 
	if (screen_get.type.equals(screen_get.types[0]) || screen_get.type.equals(screen_get.types[1]) || screen_get.type.equals(screen_get.types[2])) {}
	else {
		System.out.println("Тип батареи не соответствует IPS, OLED, AMOLED.\n Оставить(0) или изменить(1) тип: ");
		choice = in.nextInt();
		if (choice == 1) {
			System.out.println("Введите тип экрана:");
			screen_get.type = in.next();
		}
	}
	System.out.println("Проверка завершена!");
}
}




class camera {
    public int main_camera;
    public int front_camera;

    public camera(int main, int front) {
        main_camera = main;
        front_camera = front;
    }
    public camera(int main){
        main_camera = main;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите разрешение(Мп) главной камеры:");
        main_camera = in.nextInt();
        System.out.println("Введите разрешение(Мп) фронтальной камеры:");
        front_camera = in.nextInt();
        
    }

    public void print(){
        System.out.println("Камера(Мп). Главная - " + main_camera + ", фронтальная  - " + front_camera);
    }

}

class battery {
    public int capacity;
    public String type;
    public String[] types = { "Li-Ion","NIMH", "NiCd" };

    public battery(int cap,String typ) {
        capacity = cap;
        type = typ;
    }
    public battery(int cap){
        capacity = cap;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
System.out.println("Введите тип батареи:");
        type = in.nextLine();
        System.out.println("Введите емкость(мАч) батареи:");
        capacity = in.nextInt();
        
        
    }

    public void print(){
        System.out.println("Батарея(мАч). Емкость - " + capacity + ", тип  - " + type);
    }

}

class memory {
    public int ram;
    public int rom;

    public memory(int ra,int ro) {
        ram = ra;
        rom = ro;
    }
    public memory(int ro){
        rom = ro;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите объем(Гб) RAM:");
        ram = in.nextInt();
        System.out.println("Введите объем(Гб) ROM:");
        rom = in.nextInt();
        
    }

    public void print(){
        System.out.println("Память(Гб). RAM - " + ram + " Гб, ROM  - " + rom + " Гб");
    }

}

class screen {
    public float diagonal;
    public String type;
    public String[] types = {"IPS","AMOLED","OLED"};

    public screen(float dia,String typ) {
        diagonal = dia;
        type = typ;
    }
    public screen(float dia){
        diagonal = dia;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите тип экрана:");
        type = in.nextLine();
        System.out.println("Введите диагональ(Дюйм) экрана:");
        diagonal = in.nextFloat();
        
        
    }

    public void print(){
        System.out.println("Экран. Диагональ - " + diagonal + " Дюйм, тип  - " + type);
    }

}

class systema {
    public String name;
    public int version;

    public systema(String nam,int ver) {
        name = nam;
        version = ver;
    }
    public systema(String nam){
        name = nam;
    }

    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите название ОС:");
        name = in.nextLine();
        System.out.println("Введите версию ОС:");
        version = in.nextInt();
        
    }

    public void print(){
        System.out.println("Система. ОС - " + name + ", Версия  - " + version);
    }

}


