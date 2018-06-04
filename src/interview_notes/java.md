# Java Fundamentals
[What is the hierarchy of JVM, JDK, JRE, JIT?](https://stackoverflow.com/questions/17408363/what-is-the-hierarchy-of-jvm-jdk-jre-jit)
[How does JVM handles bytecode](https://stackoverflow.com/questions/2203248/what-are-bytecodes-and-how-does-the-jvm-handle-them) 
[another link](https://softwareengineering.stackexchange.com/questions/286712/compilation-to-bytecode-vs-machine-code)

**_Java Virtual Machine  (JVM)_**: runs Java bytecode.
**_Java Developer Kit  (JDK)_**: compile Java source code to bytecode.
**_Java Runtime Environment  (JRE)_**: runs a Java program and contains a JVM, among other things.

![](https://i.stack.imgur.com/eUqSJ.png)

    The JVM has an instruction set just like a real machine. 
    
    The name of instruction set is Java Bytecode. (described in the Java Virtual Machine Specification.) 
    
    Other languages are translated into a bytecode before execution, for example ruby and python. 
    Java's bytecode is at a fairly low level while python's is much more high level.
    
    Compiling Java source code to JVM byte code is relatively straight forward, 
    since there is a core subset of Java that maps pretty much directly to a subset of JVM byte code.
    
    There are some differences: Java has loops but no GOTO, the JVM has GOTO but no loops, 
    Java has generics, the JVM doesn't, but those can be easily dealt with 
    (the transformation from loops to conditional jumps is trivial, type erasure slightly less so, but still manageable).
    
    Interpretation and JIT compilation are two different strategies for executing bytecode.
    
    Interpretation processes bytecodes one at a time making the changes to the virtual machine state 
    that are encoded in each instruction. 
    
    JIT compilation translates the bytecode into instructions native to the host platform that 
    carry out equivalent operations.
    
    Interpretation: quick to start, slow during execution.
    JIT: more startup overhead, but runs quicker afterwards. 
    
    Modern JVMs use a combination of interpretation and JIT techniques to get the benefit of both. 
    
    The bytecode is first interpreted while the JIT is translating it in the background. 
    
    Once the JIT compilation is complete, the JVM switches to using that code instead of the interpreter. 
    
    Sometimes JIT compilation can produce better results than the ahead-of-time compilation used for 
    C and C++ because it is more dynamic. 
    
    The JVM can keep track of how often code is called and what the typical paths through the code are 
    and use this information to generate more efficient code while the program is running. 
    
    The JVM can switch to this new code just like when it initially switches from the interpreter to the JIT code.
    
    Just like there are other languages that compile to native code, like C, C++, Fortran; there are compilers for other languages that output JVM bytecode. One example is the Scala language. I believe that groovy and jruby can also convert to java bytecode.

[Is the JVM really a virtual machine in the same sense as my VMWare?](https://stackoverflow.com/questions/861422/is-the-java-virtual-machine-really-a-virtual-machine-in-the-same-sense-as-my-vmw)

    VMWare and the rest actually virtualize the hardware of the machine. 
    
    The operating system running inside of a VMWare container has varying degrees of awareness of running within a virtualized container. 
    
    Within VMWare, the operating system has no idea that it is running within a virtual container. 
    The operating system is not modified at all, although specialized drivers are usually installed (most importantly video) to prevent performance problems. 
    
    Some other VM's don't do full hardware virtualization and instead require the OS inside the container the make special calls to the container in place of the regular hardware calls.
    
    The JVM is not a virtual machine in that sense at all, no hardware other than the processor is virtualized. 
    
    The JVM is essentially a virtualized CPU plus the same sort of runtime that is included with 
    a C++ or any other object oriented language, plus garbage collection and other necessities.
    
    Additionally, of course, Java class files (and JAR files, etc) are not machine code, but an intermediate byte code. So the JVM has to compile or interpret class files (whether contained in a JAR file or not) at runtime, and has the ability to load and find new code dynamically at runtime.
    
    The JVM is called a virtual machine because the JVM definition defines an abstract machine. 
    This includes registers, stack, etc, and the byte code that Java source is compiled to is 
    practically machine code for this virtual machine. 
    
    The JVM then interprets or compiles this byte code into native machine instructions.
    
    The difference is essentially that the JVM is a virtualized processor and the other virtual machines are 
    virtualized machines (including video card, network, and other external devices and hardware registers)
    
[5 processes of a java program are running at a same time in the server, can we say that these 5 java processes are running in 5 JVMs?](https://stackoverflow.com/questions/4301531/jvm-and-java-linux-process)

    Yes, that's correct. There is one JVM per java process.
    
[How JVM stack, heap and threads are mapped to physical memory or operation system](https://stackoverflow.com/questions/16264118/how-jvm-stack-heap-and-threads-are-mapped-to-physical-memory-or-operation-syste)

    What I don't understand is that since JVM is essentially a software, how are those JVM heap, stack and threads mapped to physical machine?

The heap is a pre-allocated continuous region of virtual memory. e.g.
    
    void* heap = malloc(Xmx); // get the maximum size.
     
The stacks are allocated by the threading library when the thread is started. Again it is a continuous region of virtual memory which is the maximum stack size. Again you could think of it as

    void* stack = malloc(Xss); // get the maximum stack size.
    
Native threads are OS features which are not part of the JVM space as such.
    
    Because Java runs on JVM, but C++ does not.
    
C++ still needs a runtime environment and libraries to start up. Try deleting your C++ Runtime or libc and these won't start.
    
    Comparing with Java, What does C++ run-time data area look like?
    
There is one large region of virtual memory you can use. There isn't a picture because it wouldn't tell you much. Imagine one long rectangle labelled user space.
    
    How the JVM heap, stack, registers and threads are mapped to operating system? 
    or I should ask how they are mapped to physical machine?
    
Again there is no magic. The JVM heap is a region of memory, a JVM stack is the same a native stack which is what C+ uses, the JVM's registers is the same as native registers which is what C+ uses and JVMs thread are actually native threads which is what C+ uses.
    
I think you are assuming there is more magic or obscurity going on than there is. Instead you should assume that the simplest, efficient and lightweight design has been used and you won't be far off.
    
    I should ask how they are mapped to physical machine?

one to one basically.
    

Runtime data area in JVM can be divided as below,

Method Area : Storage area for compiled class files. (One per JVM instance)
Heap : Storage area for Objects. (One per JVM instance)
Java stack: Storage area for local variables, results of intermediate operations. (One per thread)
Program Counter (PC) Register : Stores the address of the next instruction to be executed if the next instruction is native method then the value in pc register will be undefined. (One per thread)
Native method stacks : Helps in executing native methods (methods written in languages other than Java). (One per thread)
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTIwOTQyMDk5MywtOTA0MDU3NjAwXX0=
-->