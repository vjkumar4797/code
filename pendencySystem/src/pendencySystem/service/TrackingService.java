package pendencySystem.service;

import java.util.List;

public interface TrackingService {
	public void startTracking(Integer entityId , List<String> tags);
	public void stopTracking(Integer entityId);
	public Integer getCount(List<String> tags);
	public String getStrategy();
}
