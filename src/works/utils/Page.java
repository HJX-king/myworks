package works.utils;

public class Page {
	private int currentPage = 1;
	private int pageSize = 12;
	private int start;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"currentPage\":\"");
		builder.append(currentPage);
		builder.append("\", \"pageSize\":\"");
		builder.append(pageSize);
		builder.append("\", \"start\":\"");
		builder.append(start);
		builder.append("\"}");
		return builder.toString();
	}

}
