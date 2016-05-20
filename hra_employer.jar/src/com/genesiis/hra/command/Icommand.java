package com.genesiis.hra.command;

public interface Icommand {
	public String execute(Icommand icommand, String key);
	public Object extractFromgson();
	public boolean validate();
	
}
