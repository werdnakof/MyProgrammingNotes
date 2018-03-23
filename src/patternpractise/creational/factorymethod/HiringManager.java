package patternpractise.creational.factorymethod;

abstract class HiringManager {

    abstract Interviewer getInterviewer();

    public String interview() {
        return this.getInterviewer().askQuestion();
    }

    public static void main(String[] args) {

        HiringManager[] hiringManagers = new HiringManager[2];
        hiringManagers[0] = new DeveloperManager();
        hiringManagers[1] = new StockHolder();

        for(HiringManager hiringManager: hiringManagers) {
            System.out.println(hiringManager.interview());
        }
    }
}
