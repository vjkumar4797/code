package pendencySystem.driver;

import java.util.Arrays;

import pendencySystem.data.TrackingServiceStrategy;
import pendencySystem.service.EntityRepository;
import pendencySystem.service.TagRepository;
import pendencySystem.service.TrackingInfoRepository;
import pendencySystem.service.TrackingService;
import pendencySystem.service.TrackingServiceFactory;

public class Solution {

	public static void main(String[] args) {
		String trackingStrategy = TrackingServiceStrategy.HashMapBased.name();
		TrackingService service = TrackingServiceFactory.getTrackingService(trackingStrategy);
		EntityRepository.initialize();
		TagRepository.initialize();
		TrackingInfoRepository.initialize();		
		service.startTracking(1112, Arrays.asList("UPI", "Karnataka", "Bangalore"));
		service.startTracking(2451, Arrays.asList("UPI", "Karnataka", "Mysore"));
		service.startTracking(3421, Arrays.asList("UPI", "Rajasthan", "Jaipur"));
		service.startTracking(1221, Arrays.asList("Wallet", "Karnataka", "Bangalore"));
		System.out.println("Count of UPI : " + service.getCount(Arrays.asList("UPI")));
		System.out.println("Count of UPI,Karnataka : " + service.getCount(Arrays.asList("UPI", "Karnataka")));
		System.out.println("Count of UPI , Karanataka , Bangalore : "
				+ service.getCount(Arrays.asList("UPI", "Karnataka", "Bangalore")));
		System.out.println("Count of Bangalore : " + service.getCount(Arrays.asList("Bangalore")));
		service.startTracking(4221, Arrays.asList("Wallet", "Karnataka", "Bangalore"));
		service.stopTracking(1112);
		service.stopTracking(2451);
		System.out.println("Count of UPI : " + service.getCount(Arrays.asList("UPI")));
		System.out.println("Count of Wallet : " + service.getCount(Arrays.asList("Wallet")));
		System.out.println("Count of UPI , Karanataka , Bangalore : "
				+ service.getCount(Arrays.asList("UPI", "Karnataka", "Bangalore")));
	}

}

// UPI --> 1
// UPIKarnataka --> 1
// UPIKarnatakaBangalore --> 1
