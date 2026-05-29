/**
 * WMS - Warehouse Management System
 * Japanese Warehouse Style Application
 * Philosophy: 無駄の排除 (Eliminate Waste)
 */

console.log("WMS Application initialized - 無駄の排除");

// ===== Logout Modal Functions =====
function showLogoutModal(event) {
  if (event) event.preventDefault();
  const modal = document.getElementById("logoutModal");
  if (modal) {
    modal.classList.add("show");
  }
}

function closeLogoutModal() {
  const modal = document.getElementById("logoutModal");
  if (modal) {
    modal.classList.remove("show");
  }
}

function confirmLogout() {
  // Logout will redirect via window.location
  window.location.href =
    document.body.getAttribute("data-logout-url") || "/logout.do";
}

// Close modal when clicking outside of it
window.onclick = function (event) {
  const modal = document.getElementById("logoutModal");
  if (modal && event.target === modal) {
    closeLogoutModal();
  }
};

// ===== Keyboard Shortcuts =====
document.addEventListener("keydown", function (event) {
  // Alt + L: Open logout modal
  if (event.altKey && event.key === "l") {
    showLogoutModal();
  }
  // Escape: Close logout modal
  if (event.key === "Escape") {
    closeLogoutModal();
  }
});

// ===== Page Ready =====
document.addEventListener("DOMContentLoaded", function () {
  console.log("WMS Dashboard loaded successfully");

  // Add animations to cards
  const cards = document.querySelectorAll(".card");
  cards.forEach((card, index) => {
    setTimeout(() => {
      card.style.opacity = "0";
      card.style.transform = "translateY(20px)";
      setTimeout(() => {
        card.style.transition = "all 0.5s ease";
        card.style.opacity = "1";
        card.style.transform = "translateY(0)";
      }, 50);
    }, index * 100);
  });
});

// ===== Utility Functions =====
function formatDate(date) {
  return new Date(date).toLocaleDateString("ja-JP", {
    year: "numeric",
    month: "2-digit",
    day: "2-digit",
  });
}

function showNotification(message, type = "info") {
  console.log(`[${type.toUpperCase()}] ${message}`);
}
