package a12aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Define the pointcut where the logging should occur
    @Pointcut("execution(* a12aop.service.LoanService.*(..))")
    public void loanServiceMethods() {
        // Pointcut definition: All methods in LoanService
    }

    @Before("loanServiceMethods()")
    public void logBefore(JoinPoint joinPoint) {
        // Get the method name
        String methodName = joinPoint.getSignature().getName();
        // Get the arguments passed to the method
        Object[] args = joinPoint.getArgs();

        // Log method name and arguments
        logger.info("Executing method: " + methodName);
        if (args != null && args.length > 0) {
            logger.info("With arguments: ");
            for (Object arg : args) {
                logger.info("Argument: " + arg);
            }
        }
    }

    // After advice: Logs after the execution of the method
    @After("loanServiceMethods()")
    public void logAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Method " + methodName + " execution finished.");
    }

    //@Around("loanServiceMethods()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();

        logger.info("Executing method: " + methodName);
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                logger.info("Argument: " + arg);
            }
        }

        Object result = proceedingJoinPoint.proceed(); // Proceed with the method execution
        logger.info("Method " + methodName + " executed with result: " + result);
        return result;
    }

    /*

    @Aspect: Marks a class as an Aspect in Spring.

@Before: Advice that runs before the execution of the method.

@After: Advice that runs after the method execution.

Pointcut: The expression that matches methods where advice should be applied.
    In @Around advice, you have full control over the method execution — you can modify the arguments, change the return value, and even skip or proceed with the method invocation.

     */


}
