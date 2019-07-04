package cn.xender.libraj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cn.xender.libraj.controller.LibraApi;

@Component
public class MainLoop implements CommandLineRunner {

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		LibraApi api = new LibraApi();
		api.getBalance("b552b1d8d82dbe6b600dc7259bafe3293a7d3fcd6c158f117693254f2096aee1");
	}
}
