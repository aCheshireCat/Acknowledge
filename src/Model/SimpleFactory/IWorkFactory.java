package Model.SimpleFactory;
//ЩњВњеп
public interface IWorkFactory {
	
	Work getWork();

}

class StudentWorkFactory implements IWorkFactory {

    public Work getWork() {
        return new StudentWork();
    }

}

class TeacherWorkFactory implements IWorkFactory {

    public Work getWork() {
        return new TeacherWork();
    }

}
