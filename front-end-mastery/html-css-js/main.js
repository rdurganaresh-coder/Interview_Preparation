const topics = ["Semantic HTML", "Grid & Flexbox", "DOM & Events", "Fetch & Promises"];

const container = document.getElementById("cards");
for (const topic of topics) {
  const card = document.createElement("article");
  card.className = "card";
  card.textContent = topic;
  container.append(card);
}
