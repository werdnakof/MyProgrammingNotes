package patternpractise.creational.factorymethod;

public class StockHolder extends HiringManager {
    @Override
    Interviewer getInterviewer() {
        return new CEOInterviewer();
    }
}
