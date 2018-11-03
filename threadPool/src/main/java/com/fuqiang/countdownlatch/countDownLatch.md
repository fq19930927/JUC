CountDownLatch（同步工具类） 允许一个或多个线程等待其他线程完成操作。
CountDownLatch 时，需要指定一个整数值，此值是线程将要等待的操作数。当某个线程为了要执行这些操
作而等待时，需要调用 await 方法。await 方法让线程进入休眠状态直到所有等待的操作完成为止。当等待
的某个操作执行完成，它使用 countDown 方法来减少 CountDownLatch 类的内部计数器。当内部计数器递
减为 0 时，CountDownLatch 会唤醒所有调用 await 方法而休眠的线程们。


原理：
CountDownLatch 的构造函数接收一个 int 类型的参数作为计数器，如果你想等待 N 个点完
成，这里就传入 N。
当我们调用 CountDownLatch 的 countDown 方法时，N 就会减 1，CountDownLatch 的 await 方法
会阻塞当前线程，直到 N 变成零。由于 countDown 方法可以用在任何地方，所以这里说的 N 个


场景：
并行计算
依赖启动
CountDownLatch  是一次性的，只能通过构造方法设置初始计数量，计数完了无法进行复位，不能达到复用。
可以实现类似于：FutureTask 和 Join 等功