package com.maveric.core.testng.listeners;

import com.maveric.core.config.ConfigProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;
import org.testng.xml.XmlSuite;

public class TestListener implements ISuiteListener, ITestListener {
    public static final Logger logger = LogManager.getLogger();


    @Override
    public void onStart(ISuite suite) {

        setThreadCount(suite);
    }


    @Override
    public void onTestStart(ITestResult result) {
        IRetryAnalyzer curRetryAnalyzer = getRetryAnalyzer(result);
        if (curRetryAnalyzer == null) {
            result.getMethod().setRetryAnalyzer(curRetryAnalyzer);
        }

    }


    public void setThreadCount(ISuite suite) {
        if (ConfigProperties.THREAD_COUNT.getInt() >= 1) {
            int count = ConfigProperties.THREAD_COUNT.getInt();
            suite.getXmlSuite().setThreadCount(count);
            logger.info("Thread Count : " + count);
        }

        if (ConfigProperties.DATAPROVIDER_COUNT.getInt() >= 1) {
            int count = ConfigProperties.DATAPROVIDER_COUNT.getInt();
            suite.getXmlSuite().setThreadCount(ConfigProperties.DATAPROVIDER_COUNT.getInt());
            logger.info("Data Provider Count : " + count);
        }

        if (suite.getXmlSuite().getParallel() == XmlSuite.ParallelMode.NONE) {
            suite.getXmlSuite().setParallel(XmlSuite.ParallelMode.METHODS);
            logger.info("Parallel Type : Methods");
        }

    }


    private RetryAnalyzer getRetryAnalyzer(ITestResult result) {
        RetryAnalyzer retryAnalyzer = null;
        IRetryAnalyzer iRetry = result.getMethod().getRetryAnalyzer();
        if (iRetry instanceof RetryAnalyzer) {
            retryAnalyzer = (RetryAnalyzer) iRetry;
        }
        return retryAnalyzer;
    }


	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

}
