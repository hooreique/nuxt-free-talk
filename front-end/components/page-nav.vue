<script setup>
const {
  number,
  totalPages,
  setPageNo,
  navLength,
} = defineProps([
  'number',
  'total-pages',
  'set-page-no',
  'nav-length',
]);

const navLen = navLength > 0 ? navLength : 1;
const pageCount = totalPages > 0 ? totalPages : 1;

if (number >= pageCount) {
  setPageNo(pageCount - 1);
}

const navCount = Math.ceil(pageCount / navLen);
const lastNavLength = ((pageCount - 1) % navLen) + 1;

const navNo = Math.floor(number / navLen);
const lastNavNo = navCount - 1;

const isFirstNav = navNo === 0;
const isLastNav = navNo === lastNavNo;

const startNo = navLen * navNo;
const startNoOfNext = startNo + navLen;
const endNoOfPrev = startNo - 1;

const numbers = computed(() => {
  const numbers = [];
  for (let i = 0; i < (isLastNav ? lastNavLength : navLen); ++i) {
    numbers.push(startNo + i);
  }
  return numbers;
});
</script>

<template>
  <nav>
    <ul>
      <li>
        <button @click.prevent.stop="() => setPageNo(0)"
                :disabled="number === 0">
          1
        </button>
      </li>
      <li>
        <button @click.prevent.stop="() => setPageNo(endNoOfPrev)"
                :disabled="isFirstNav">
          {{ isFirstNav ? '-' : endNoOfPrev + 1 }}
        </button>
      </li>
      <li>
        <ul>
          <li v-for="n in numbers" :key="n">
            <button @click.prevent.stop="() => setPageNo(n)"
                    :disabled="n === number">
              {{ n + 1 }}
            </button>
          </li>
        </ul>
      </li>
      <li>
        <button @click.prevent.stop="() => setPageNo(startNoOfNext)"
                :disabled="isLastNav">
          {{ isLastNav ? '-' : startNoOfNext + 1 }}
        </button>
      </li>
      <li>
        <button @click.prevent.stop="() => setPageNo(pageCount - 1)"
                :disabled="number === pageCount - 1">
          {{ pageCount }}
        </button>
      </li>
    </ul>
  </nav>
</template>
