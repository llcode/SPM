package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

public class Poem {

	private Integer pid;
	private String title;
	private String content;
	private String translation;
	private String explanation;
	private String appreciation;

	private Author author;

	private Set<Favorite> favoriteLists;
	private Set<MyNewPoem> newLists;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getAppreciation() {
		return appreciation;
	}

	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<Favorite> getFavoriteLists() {
		return favoriteLists;
	}

	public void setFavoriteLists(Set<Favorite> favoriteLists) {
		this.favoriteLists = favoriteLists;
	}

	public Set<MyNewPoem> getNewLists() {
		return newLists;
	}

	public void setNewLists(Set<MyNewPoem> newLists) {
		this.newLists = newLists;
	}

	// get the sentences from a poem.
	public List<String> getSentences() {
		String punctuations = "[,.!?;£¬¡££¡£¿£»]";
		String[] sentences = content.split(punctuations);
		return new ArrayList<String>(Arrays.asList(sentences));
	}

	// get the punctuations from a poem.
	public String getPuncs() {
		String punctuations = "[^,.!?;£¬¡££¡£¿£»]";
		return Pattern.compile(punctuations).matcher(content).replaceAll("");
	}

	// generate the blanks from a poem.
	public List<Integer> geneRand(double percent) {
		Random rand = new Random();
		int length = getSentences().size();
		List<Integer> res = new ArrayList<Integer>();
		int blanks = (int) (length * percent);
		while (res.size() < blanks) {
			Integer i = rand.nextInt(length);
			if (!res.contains(i))
				res.add(i);
		}
		return res;
	}

}
