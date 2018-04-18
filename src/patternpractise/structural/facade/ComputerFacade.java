package patternpractise.structural.facade;

public class ComputerFacade
{
    protected Computer computer;

    public ComputerFacade(Computer computer) {
        this.computer = computer;
    }

    public void turnOn()
    {
        this.computer.getElectricShock();
        this.computer.makeSound();
        this.computer.showLoadingScreen();
        this.computer.bam();
    }

    public void turnOff()
    {
        this.computer.closeEverything();
        this.computer.pullCurrent();
        this.computer.sooth();
    }

    public static void main(String[] args) {
        ComputerFacade cf = new ComputerFacade(new Computer());
        cf.turnOn();
        cf.turnOff();
    }
}
