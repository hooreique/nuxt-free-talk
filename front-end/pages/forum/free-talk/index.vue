<script setup>
definePageMeta({
  key: route => route.fullPath,
  validate: validatePageQuery,
});

const {query} = useRoute();

const setPageNo = number => useRouter().push({query: {...query, page: number}});

const {data} = await useFetch('/forum/free-talk', {
  method: 'GET',
  baseURL: 'http://localhost:8080/api',
  query,
});
</script>

<template>
  <NuxtLayout>
    <NuxtLayout name="forum">
      <div v-if="data.totalElements === 0">Empty!</div>
      <div v-else>
        <PageNav :number="data.number" :total-pages="data.totalPages"
                 :set-page-no="setPageNo" :nav-length="10"/>
        <table>
          <thead>
          <tr>
            <th>ID</th>
            <th>제목</th>
            <th>작성자</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="post in data.content" :key="post.id">
            <td>{{ post.id }}</td>
            <td>{{ post.title }}</td>
            <td>{{ post.authorName }}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </NuxtLayout>
  </NuxtLayout>
</template>
