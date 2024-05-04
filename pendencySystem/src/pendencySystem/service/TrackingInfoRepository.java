package pendencySystem.service;

import java.util.HashMap;
import java.util.Map;

import pendencySystem.domain.TrackingInfo;
import pendencySystem.domain.TrackingStatus;

public class TrackingInfoRepository {
	private static Map<Integer, TrackingInfo> trackingInfoRepository;
	
	public static void initialize() {
		trackingInfoRepository = new HashMap<>();
	}

	public synchronized static void startTracking(Integer entityId) {
		if (trackingInfoRepository.containsKey(entityId)) {
			TrackingInfo info = trackingInfoRepository.get(entityId);
			if (info.getTrackingStatus().equals(TrackingStatus.BEGIN)) {
				throw new RuntimeException("Entity with id " + entityId + " is already being tracked");
			}
		}
		TrackingInfo info = new TrackingInfo(entityId, TrackingStatus.BEGIN);
		trackingInfoRepository.put(entityId, info);
	}

	public synchronized static void stopTracking(Integer entityId) {
		if (!trackingInfoRepository.containsKey(entityId)) {
			throw new RuntimeException("Entity with id " + entityId + " is not being tracked");
		}
		trackingInfoRepository.get(entityId).setTrackingStatus(TrackingStatus.END);
	}

}
