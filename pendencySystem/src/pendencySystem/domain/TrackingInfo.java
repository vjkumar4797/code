package pendencySystem.domain;

public class TrackingInfo {
	private Integer entityId;
	private String trackingStatus;

	public TrackingInfo(Integer entityId, TrackingStatus trackingStatus) {
		this.entityId = entityId;
		this.trackingStatus = trackingStatus.name();
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public TrackingStatus getTrackingStatus() {
		return TrackingStatus.valueOf(trackingStatus);
	}

	public void setTrackingStatus(TrackingStatus trackingStatus) {
		this.trackingStatus = trackingStatus.name();
	}
}
