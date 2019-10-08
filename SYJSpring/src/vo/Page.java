package vo;

public class Page {
	
	private int start, current, end;
	private boolean next;
	private int contentCount, pageCount, totalPageCount;
	
	public Page(int total, int current, int contentCount, int pageCount) {
		
		this(current, contentCount, pageCount);
		initTotal(total);
		
	} //Page();
	
	public Page(int current, int contentCount, int pageCount) {
		
		this.contentCount = contentCount;
		this.pageCount = pageCount;
		this.current = current;
		start = Math.max(1, this.current - (this.pageCount-1) / 2);
		
	} //Page();
	
	public Page initTotal(int total) {
		
		totalPageCount = (total + (contentCount - 1)) / contentCount;
		end = Math.min(start + pageCount - 1, totalPageCount);
		
		if((end = start + pageCount - 1) > totalPageCount) {
			end = totalPageCount;
			start = end - pageCount + 1;
		}
		
		next = end < totalPageCount;
		
		return this;
		
	} //initTotal();
	
	public int getStart() { return start; }
	public int getCurrent() { return current; }
	public int getEnd() { return end; }
	public boolean isNext() { return next; }
	public int getStartContent() { return (current - 1) * contentCount; }
	public int getContentCount() { return contentCount; }
	public int getPageCount() { return pageCount; }
	public int getTotalPageCount() { return totalPageCount; }
	public void setStart(int start) { this.start = start; }
	public void setCurrent(int current) { this.current = current; }
	public void setEnd(int end) { this.end = end; }
	public void setNext(boolean next) { this.next = next; }
	public void setContentCount(int contentCount) { this.contentCount = contentCount; }
	public void setPageCount(int pageCount) { this.pageCount = pageCount; }
	public void setTotalPageCount(int total) { this.totalPageCount = total; }
	
	@Override
	public String toString() {
		return "Page [start=" + start + ", current=" + current + ", end=" + end + ", next=" + next + ", contentCount="
				+ contentCount + ", pageCount=" + pageCount + ", totalPageCount=" + totalPageCount + "]";
	} //toString();
	
} //class Page;
