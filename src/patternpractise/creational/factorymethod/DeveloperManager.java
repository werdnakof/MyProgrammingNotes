package patternpractise.creational.factorymethod;

public class DeveloperManager extends HiringManager {
    @Override
    Interviewer getInterviewer() {
        return new DeveloperInterviewer();
    }
}
