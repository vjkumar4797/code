package pendencySystem.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrackingServiceFactory {

	private static final Map<String, TrackingService> trackingServiceMap = new HashMap<>();
	private static final List<TrackingService> trackingServices = Arrays.asList(new TrackingServiceHashMapBasedImpl(),
			new TrackingServiceTrieImpl());

	static {
		trackingServices.stream().forEach(trackingService -> {
			trackingServiceMap.put(trackingService.getStrategy(), trackingService);
		});
		
	}

	public static TrackingService getTrackingService(String strategy) {
		return trackingServiceMap.get(strategy);
	}
}
