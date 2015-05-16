package disasterRecovery;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.AWSLambdaClient;
import com.amazonaws.services.lambda.model.InvokeRequest;

import org.json.simple.JSONObject;

public class LambdaInvoke {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AWSCredentials credentials = new BasicAWSCredentials("AKIAJCDVFGC425YXTY5Q","dGT7/DDUXzNpyaiC+fS6re3747W1C16/CZK3iC3O");
		AWSLambdaClient alc=new AWSLambdaClient( credentials); 
		//alc.setEndpoint("arn:aws:lambda:us-west-2:257864378183:function:cmpe273");
		 
		JSONObject invokeObj=new JSONObject();
		invokeObj.put("tweets","value1"); 
		
		
		
		InvokeRequest invokeRequest =new  InvokeRequest();
		invokeRequest.setFunctionName("cmpe273East1");
		invokeRequest.setPayload(invokeObj.toJSONString());
		alc.invoke(invokeRequest);
	//	alc.setConfiguration(   );
		
  

	}

}
	