<template>
  <nav>
    <ul>
      <li>
        <NuxtLink to="/forum">Root</NuxtLink>
      </li>
      <li>
        <NuxtLink :to="{
                  path: '/forum/free-talk',
                  query: {
                    page: 0,
                    size: 10,
                    sort: 'id,desc',
                  },
                }">Free Talk
        </NuxtLink>
      </li>
      <li>
        <NuxtLink to="/forum/dev-talk">Dev Talk</NuxtLink>
      </li>
    </ul>
  </nav>
</template>
