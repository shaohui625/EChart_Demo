package org.hy.echart.demo;

import org.nutz.aop.AopCallback;
import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.lang.Lang;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * Created by evilspirit on 30/06/2015.
 */
public class LoggingInterceptor implements MethodInterceptor {

    private static final Log LOG = Logs.get();

    protected boolean logBeforeInvoke;
    protected boolean logAfterInvoke;
    protected boolean logWhenException;
    protected boolean logWhenError;

    public LoggingInterceptor() {
        this.logBeforeInvoke = LOG.isDebugEnabled();
        this.logAfterInvoke = LOG.isDebugEnabled();
        this.logWhenException = LOG.isDebugEnabled();
        this.logWhenError = LOG.isDebugEnabled();
    }

    public void setLogEvent(boolean logBeforeInvoke,
                            boolean logAfterInvoke,
                            boolean logWhenException,
                            boolean logWhenError) {
        this.logBeforeInvoke = logBeforeInvoke && LOG.isDebugEnabled();
        this.logAfterInvoke = logAfterInvoke && LOG.isDebugEnabled();
        this.logWhenException = logWhenException && LOG.isDebugEnabled();
        this.logWhenError = logWhenError && LOG.isDebugEnabled();
    }
    public void filter(InterceptorChain chain) throws Throwable {
        try {
            if (logBeforeInvoke)
                LOG.debugf("[beforeInvoke] %s , Method = %s , args = %s",
                        toString(chain.getCallingObj()),
                        chain.getCallingMethod(),
                        str(chain.getArgs()));
            chain.doChain();
        }
        catch (Exception e) {
            if (logWhenException)
                LOG.debugf("[whenException] %s , Throwable = %s , Method = %s , args = %s",
                        toString(chain.getCallingObj()),
                        e,
                        chain.getCallingMethod(),
                        str(chain.getArgs()));
            throw Lang.wrapThrow(e);
        }
        catch (Throwable e) {
            if (logWhenError)
                LOG.debugf("[whenError] %s , Throwable = %s , Method = %s , args = %s",
                        toString(chain.getCallingObj()),
                        e,
                        chain.getCallingMethod(),
                        str(chain.getArgs()));
            throw Lang.wrapThrow(e);
        }
        finally {
            if (logAfterInvoke)
                LOG.debugf("[afterInvoke] %s , Return = %s , Method = %s , args = %s",
                        toString(chain.getCallingObj()),
                        chain.getReturn(),
                        chain.getCallingMethod(),
                        str(chain.getArgs()));
        }
    }

    protected static final String toString(Object object) {
        if (object != null )
            if (object instanceof AopCallback)
                return "[" + object.getClass().getName() + "]";
        String str = String.valueOf(object);
        if (str.length() > 100)
            str = str.substring(0,97) + "...";
        return str;
    }

    protected static final String str(Object... args) {
        if (args == null || args.length == 0)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Object object : args)
            sb.append(toString(object)).append(",");
        sb.replace(sb.length() - 1, sb.length(), "]");
        return sb.toString();
    }
}
